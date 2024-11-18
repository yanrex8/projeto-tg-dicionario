import os
import json
import uuid

# Function to read a txt file into a dictionary
def read_ipa_file(file_path):
    ipa_dict = {}
    with open(file_path, 'r', encoding='utf-8') as file:
        for line in file:
            word, ipa = line.strip().split('\t')
            ipa_dict[word.lower()] = ipa  # Use lower() for case-insensitive matching
    return ipa_dict

# US to UK conversion rules
conversion_rules = [
    ('ae', 'e'),
    ('oe', 'e'),
    ('ise', 'ize'),
    ('yse', 'yze'),
    ('ll', 'l'),
    ('ler', 'lle'),
    ('our', 'or'),
    ('re', 'er'),
    ('ogue', 'og')
]

# Function to convert British words to American equivalents
def convert_to_us(word):
    for uk, us in conversion_rules:
        if word.endswith(uk):
            return word[:-len(uk)] + us
    return word

# Get the directory where the script is located
script_dir = os.path.dirname(os.path.abspath(__file__))

# Define the paths to the files
english_definitions_path = os.path.join(script_dir, 'merged.json')
us_ipa_path = os.path.join(script_dir, 'en_US.txt')
uk_ipa_path = os.path.join(script_dir, 'en_UK.txt')

# Load the JSON file
with open(english_definitions_path, 'r', encoding='utf-8') as file:
    english_definitions = json.load(file)

# Load the American IPA pronunciations
us_ipa = read_ipa_file(us_ipa_path)

# Load the British IPA pronunciations
uk_ipa = read_ipa_file(uk_ipa_path)

# Function to extract definitions and examples
def extract_definitions(meanings):
    noun_definitions, verb_definitions, adj_definitions = [], [], []
    noun_examples, verb_examples, adj_examples = [], [], []
    
    for meaning in meanings:
        pos, definition, related, examples = meaning
        example_text = '\n'.join(examples) if examples else ""
        if pos == "Noun":
            noun_definitions.append(definition)
            if example_text:
                noun_examples.append(example_text)
        elif pos == "Verb":
            verb_definitions.append(definition)
            if example_text:
                verb_examples.append(example_text)
        elif pos == "Adjective":
            adj_definitions.append(definition)
            if example_text:
                adj_examples.append(example_text)
    
    return (
        '\n'.join(noun_definitions),
        '\n'.join(noun_examples),
        '\n'.join(verb_definitions),
        '\n'.join(verb_examples),
        '\n'.join(adj_definitions),
        '\n'.join(adj_examples)
    )

# Step 1: Process US words first
merged_data = []
word_entries = {}

for word, data in english_definitions.items():
    word_lower = word.lower()

    # Skip words without US pronunciation
    if word_lower not in us_ipa:
        continue

    meanings = data.get("MEANINGS", [])
    if not meanings:
        continue

    us_word = word_lower
    us_pronounciation = us_ipa[us_word]
    uk_word = ""
    uk_pronounciation = ""

    (
        noun_definitions, noun_examples,
        verb_definitions, verb_examples,
        adj_definitions, adj_examples
    ) = extract_definitions(meanings)
    
    entry = {
        "_id": str(uuid.uuid4()),
        "usWord": us_word.upper(),
        "usPronounciation": us_pronounciation,
        "ukWord": uk_word,
        "ukPronounciation": uk_pronounciation,
        "nounDefinition": noun_definitions,
        "nounExample": noun_examples,
        "verbDefinition": verb_definitions,
        "verbExample": verb_examples,
        "adjectiveDefinition": adj_definitions,
        "adjectiveExample": adj_examples,
        "synonyms": data.get("SYNONYMS", []),
        "antonyms": data.get("ANTONYMS", []),
        "translations": {}  # Set by hand as needed
    }
    
    merged_data.append(entry)
    word_entries[us_word] = entry

# Step 2: Process UK words and match them to US words
for word, ipa in uk_ipa.items():
    word_lower = word.lower()

    # Check if there's a US entry with the same spelling
    if word_lower in word_entries:
        entry = word_entries[word_lower]
        entry["ukWord"] = word.upper()
        entry["ukPronounciation"] = ipa
    else:
        # Convert UK word to US equivalent and check if it exists
        converted_us_word = convert_to_us(word_lower)
        if converted_us_word in word_entries:
            entry = word_entries[converted_us_word]
            entry["ukWord"] = word.upper()
            entry["ukPronounciation"] = ipa

# Save the merged data to a new JSON file
output_path = os.path.join(script_dir, 'merged_data.json')
with open(output_path, 'w', encoding='utf-8') as file:
    json.dump(merged_data, file, indent=4, ensure_ascii=False)

print("Data merged successfully!")
