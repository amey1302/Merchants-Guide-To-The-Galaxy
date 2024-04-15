#  Merchant's Guide to the Galaxy

Welcome to the Merchant's Guide to the Galaxy! If you're ready to embark on a journey through the cosmos, trading common metals and dirt for fortunes, you've come to the right place.

## Overview

In the wake of Earth's financial collapse, you've decided to seek your fortune among the stars. Armed with nothing but a spaceship and a dream, you'll navigate the complexities of intergalactic commerce using a unique system of symbols and values.

## Intergalactic Numerals

Our intergalactic transactions are based on a system similar to Roman numerals, with seven symbols representing different values:

| Symbol | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1,000 |

- Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. 
- When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.
- The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
- "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
- Only one small-value symbol may be subtracted from any large-value symbol.
- A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.

For more details, you can refer to [Wikipedia](http://en.wikipedia.org/wiki/Roman_numerals).

Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.
 
You are expected to handle invalid queries appropriately.
 
Test input:
- glob is I
- prok is V
- pish is X
- tegj is L

- glob glob Silver is 34 Credits
- glob prok Gold is 57800 Credits
- pish pish Iron is 3910 Credits
- how much is pish tegj glob glob ?
- how many Credits is glob prok Silver ?
- how many Credits is glob prok Gold ?
- how many Credits is glob prok Iron ?
- how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
 
Test Output:
- pish tegj glob glob is 42
- glob prok Silver is 68 Credits
- glob prok Gold is 57800 Credits
- glob prok Iron is 782 Credits
- I have no idea what you are talking about


## Solution Overview

### Assumptions :
1. Considered the fact that the Input File is a Source of Truth.

### InterGalacticTransactionController

Delegates responsibilities to the `InterGalacticService` for handling queries.

- Behavior:
  - `double calculateCredits(String query)`: Invokes `interGalacticTransactionService.calculateCredits(query)`.

### IO
  - TranslationFileReader :
    - `String readFile(String path)`: Validates file paths and reads content and returns List<String> lines
  - Parsing:
    - `Map<String, String> parser(String lines)`: Parses units to Roman numerals, credits to units, and optional questions.

### InterGalacticTransactionService
- `public void readFileAndParse(String filePath)` : read and parse the file and stores data in the Repository.
- `double calculateCredits(String query)`: Validates query using map content and calculates credits using `CreditCalculator`.
### Repository:
  - `InterGalacticTransactionRepository`: Stores data in the in-memory database.
    - Stores Data in InMemoryDatabase
    - 
### Domain
- Service:
  - `CreditCalculator`: Handles credit calculations.
- Model:
  - `RomanNumeral`: Represents Roman numerals (e.g., I = 1).
  - `metalCredit`: Represents credit values for metals.
