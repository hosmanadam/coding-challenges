## Hi stranger!
This is the repo where I collect all of my work on various coding challenges.\
I'm not sure why you're here, but I hope you'll find something interesting.\
The following parts of this readme will detail some standards/conventions I use to keep things organized around here.

***

### Profiles
- Codewars: https://www.codewars.com/users/adamhosman
- Project Euler: https://projecteuler.net/progress=adamhosman

### Versions
- Of any challenge, only one version is live in the current file, and that is my best version (may not be the most recent one)
- Other solutions may be left in for reference, but are commented out
- All solutions are mine, unless explicitly noted
- Order:
    1. My solutions, most recent first (may not be the best one)
    2. Other solutions to learn from
    3. Tests

### Project names
- Filename is kebab-case version of challenge title, with non-alpha characters removed
- Files are put in identically named folders
    - Project Euler: folder name is prefixed with *problem number*, followed by underscore
    - Codewars: folder name is prefixed with *kyu grading of kata*, followed by underscore

### Commits
- Solutions are committed one by one
- Commit messages are [*one verb in imperative mood*] + [*filename*], where verb may be 'Solve' / 'Improve' / 'Refactor'
    - Exception: when the same non-specific changes (i.e. formatting) are applied to more than one file, blanket messages such as 'Update formatting' may be used

### Formatting
#### PEP-8
- This is mostly followed, but manually (having an app rewrite my code seems extreme and lazy)
- Indentation is 2 spaces for now, because that's what I've been doing for months (I may reformat all of the files later)
#### Empty lines
- Separating blocks by empty lines is done with as few lines as possible
- If a hierarchy arises between empty lines (some denote higher degree of separation than others), only then is more than one newline added
#### Comments
- When a multi-block section is commented out, the empty lines in between also include the comment character to signify that those parts belong together
- Version desctiptions in `"""triple quotes"""`:
    - go above the solutions, not inside the function definition\
      (they're not meant to be docstrings: they may refer to multiple functions below them)
    - are not commented out via `#`, even if their respective solution is\
      (this makes them stand out and visibly segments the file into parts)
### TODO
- Convert print tests to unit tests
