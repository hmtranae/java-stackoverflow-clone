In this challenge, you will build a website like [stackoverflow.com](http://stackoverflow.com/) for posting questions and answers. This is a *large* challenge. Expect that it will take a few days of work to complete.

## Getting Started

```no-highlight
createdb rescue_mission_development
et get java-rescue-mission
cd java-rescue-mission
idea .
```

## Core User Stories

### Post a Question

```no-highlight
As a user
I want to post a question
So that I can receive help from others
```

Acceptance Criteria

- I must provide a title that is at least 20 characters long
- I must provide a description that is at least 50 characters long
- I must be presented with errors if I fill out the form incorrectly

### View All Questions

```no-highlight
As a user
I want to view recently posted questions
So that I can help others
```

Acceptance Criteria

- I must see the title of each question
- I must see the posting date of each question formatted as `January 01 2019`
- I must see questions listed in order, most recently posted first

### View a Question's Details

```no-highlight
As a user
I want to view a question's details
So that I can effectively understand the question
```

Acceptance Criteria

- I must be able to get to this page from the questions index
- I must see the question's title
- I must see the question's description

### Answering a Question

```no-highlight
As a user
I want to answer another user's question
So that I can help them solve their problem
```

Acceptance Criteria

- I must be on the question detail page
- I must provide a description that is at least 50 characters long
- I must be presented with errors if I fill out the form incorrectly

### Viewing a Question's Answers

```no-highlight
As a user
I want to view the answers for a question
So that I can learn from the answer
```

Acceptance Criteria

- I must be on the question detail page
- I must only see answers to the question I'm viewing
- I must see all answers listed in order, most recent last

Implementation Details:

- Answers should be fetched, loaded and rendered via ReactJS

## Non-Core User Stories

### Editing a Question

```no-highlight
As a user
I want to edit a question
So that I can correct any mistakes or add updates
```

Acceptance Criteria

- I must provide valid information
- I must be presented with errors if I fill out the form incorrectly
- I must be able to get to the edit page from the question details page

### Deleting a Question

```no-highlight
As a user
I want to delete a question
So that I can delete duplicate questions
```

Acceptance Criteria

- I must be able delete a question from the question edit page
- I must be able delete a question from the question details page
- All answers associated with the question must also be deleted

### Markdown Support

```no-highlight
As a user
I want to write my questions and answers with markdown
So I can easily format my questions and answers
```

Acceptance Criteria

- I can write my questions and answers using markdown syntax
- Questions and answers, when shown, should be the HTML rendered from the
  markdown