#'findAnEven called with list containing all odds 6.0001 Problem Set 3
#
# The 6.0001 Word Game
# Created by: Kevin Luu <luuk> and Jenna Wiens <jwiens>
#
import math
import random
import string
import copy

VOWELS = 'aeiou'
CONSONANTS = 'bcdfghjklmnpqrstvwxyz'
HAND_SIZE = 7

SCRABBLE_LETTER_VALUES = {
        'a': 1, 'b': 3, 'c': 3, 'd': 2, 'e': 1, 'f': 4, 'g': 2, 'h': 4, 'i': 1, 'j': 8, 'k': 5, 'l': 1, 'm': 3, 'n': 1, 'o': 1, 'p': 3, 'q': 10, 'r': 1, 's': 1, 't': 1, 'u': 1, 'v': 4, 'w': 4, 'x': 8, 'y': 4, 'z': 10, '*': 0
}


WORDLIST_FILENAME = "words.txt"

def load_words():
    """
    Returns a list of valid words. Words are strings of lowercase letters.
    
    Depending on the size of the word list, this function may
    take a while to finish.
    """
    
    print("Loading word list from file...")
    # inFile: file
    inFile = open(WORDLIST_FILENAME, 'r')
    # wordlist: list of strings
    wordlist = []
    for line in inFile:
        wordlist.append(line.strip().lower())
    print("  ", len(wordlist), "words loaded.")
    return wordlist

def get_frequency_dict(sequence):
    """
    Returns a dictionary where the keys are elements of the sequence
    and the values are integer counts, for the number of times that
    an element is repeated in the sequence.

    sequence: string or list
    return: dictionary
    """
    
    # freqs: dictionary (element_type -> int)
    freq = {}
    for x in sequence:
        freq[x] = freq.get(x,0) + 1
    return freq
	

# Problem #1: Scoring a word
#
def get_word_score(word, n):
    """
    Returns the score for a word. Assumes the word is a
    valid word.

    You may assume that the input word is always either a string of letters, 
    or the empty string "". You may not assume that the string will only contain 
    lowercase letters, so you will have to handle uppercase and mixed case strings 
    appropriately. 

	The score for a word is the product of two components:

	The first component is the sum of the points for letters in the word.
	The second component is the larger of:
            1, or
            7*wordlen - 3*(n-wordlen), where wordlen is the length of the word
            and n is the hand length when the word was played

	Letters are scored as in Scrabble; A is worth 1, B is
	worth 3, C is worth 3, D is worth 2, E is worth 1, and so on.

    word: string
    n: int >= 0
    returns: int >= 0
    """
    word = word.lower()
    scoreletter = 0
    for c in word:
        scoreletter = scoreletter + SCRABBLE_LETTER_VALUES[c]
    scorelength = 7*len(word) - 3*(n-len(word))
    if scorelength < 1:
        scorelength = 1
    return scoreletter * scorelength
#
def test_get_word_medium():
    assert get_word_score("abba",5) == 200 
def test_get_word_empty():
    assert get_word_score("",5) == 0 
# Make sure you understand how this function works and what it does!
def display_hand(hand):
    """
    Displays the letters currently in the hand.

    For example:
       display_hand({'a':1, 'x':2, 'l':3, 'e':1})
    Should print out something like:
       a x x l l l e
    The order of the letters is unimportant.

    hand: dictionary (string -> int)
    """
    
    for letter in hand.keys():
        for j in range(hand[letter]):
             print(letter, end=' ')      # print all on the same line
    print()                              # print an empty line

#
# Make sure you understand how this function works and what it does!
# You will need to modify this for Problem #4.
#
def deal_hand(n):
    """
    Returns a random hand containing n lowercase letters.
    ceil(n/3) letters in the hand should be VOWELS (note,
    ceil(n/3) means the smallest integer not less than n/3).

    Hands are represented as dictionaries. The keys are
    letters and the values are the number of times the
    particular letter is repeated in that hand.

    n: int >= 0
    returns: dictionary (string -> int)
    """
    
    hand={}
    num_vowels = int(math.ceil(n / 3))
    #making space for wild
    num_vowels -= 1
    #adding wild to hand
    hand.update({'*': 1})
    for i in range(num_vowels):
        x = random.choice(VOWELS)
        hand[x] = hand.get(x, 0) + 1
    
    for i in range(num_vowels + 1 , n):    
        x = random.choice(CONSONANTS)
        hand[x] = hand.get(x, 0) + 1
    
    return hand

def test_deal_hand():
    myhand = deal_hand(7)
    wilds = 0
    vowels = 0
    consonants = 0
    for letter in myhand:
        if letter in VOWELS:
            vowels += 1
        if letter in CONSONANTS:
            consonants += 1
        if letter == '*':
            wilds += 1
    assert wilds  == 1 and vowels == 2 and consonants == 4
#
# Problem #2: Update a hand by removing letters
#
def update_hand(hand, word):
    """
    Does NOT assume that hand contains every letter in word at least as
    many times as the letter appears in word. Letters in word that don't
    appear in hand should be ignored. Letters that appear in word more times
    than in hand should never result in a negative count; instead, set the
    count in the returned hand to 0 (or remove the letter from the
    dictionary, depending on how your code is structured). 

    Updates the hand: uses up the letters in the given word
    and returns the new hand, without those letters in it.

    Has no side effects: does not modify hand.

    word: string
    hand: dictionary (string -> int)    
    returns: dictionary (string -> int)
    """
    newhand  = copy.deepcopy(hand)
    word = word.lower()
    for letter in word:
        if letter in newhand:
            if newhand[letter] > 0:
                newhand[letter] -= 1
            if newhand[letter] <= 0:
                del newhand[letter]
            else:
                pass
    return newhand

def test_update_hand_norm():
    assert update_hand({'a':2,'b':2,'c':1}, 'abba') == {'c':1} 
def test_update_hand_caps():
    assert update_hand({'a':2,'b':2,'c':1}, 'Abba') == {'c':1} 
#
# Problem #3: Test word validity
#
def is_valid_word(word, hand, word_list):
    """
    Returns True if word is in the word_list and is entirely
    composed of letters in the hand. Otherwise, returns False.
    Does not mutate hand or word_list.
   
    word: string
    hand: dictionary (string -> int)
    word_list: list of lowercase strings
    returns: boolean
    """
    def check_word(word, hand, word_list): 
        word = word.lower() 
        newhand  = copy.deepcopy(hand)
        if word in word_list:
            for letter in word:
                if letter in newhand:
                    if newhand[letter] > 0:
                        newhand[letter] -= 1
                    elif newhand[letter] <= 0:
                        return False
                else:
                    return False
            return True
        else: 
            return False

    wildplace = word.find('*')
    if wildplace > 0:
        for vowel in VOWELS: 
            word = word[0:wildplace] + vowel + word[wildplace + 1:len(word)]
            replacedhand = copy.deepcopy(hand)
           #add vowel we are testing to hand
            replacedhand[vowel] = hand.get(vowel, 0) + 1
            isword = check_word(word, replacedhand, word_list)
            if isword:
                return True
        return False
    else: 
        return check_word(word, hand, word_list)
def testTrue_is_valid_word():
    wordlist = load_words()
    assert is_valid_word('abase', {'a':2,'b':2,'c':1,'e':1,'s':1}, wordlist ) == True
def testWildTrue_is_valid_word():
    wordlist = load_words()
    assert is_valid_word('ab*se', {'a':1,'b':2,'c':1,'e':1,'s':1,'*':1}, wordlist ) == True
def testNotInWordlist_is_valid_word():
    wordlist = load_words()
    assert is_valid_word('abca', {'a':2,'b':2,'c':1,'e':1,'s':1}, wordlist ) == False
def testNotEnoughLetters_is_valid_word():
    wordlist = load_words()
    assert is_valid_word('abase', {'a':1,'b':2,'c':1,'e':1,'s':1}, wordlist ) == False
#
# Problem #5: Playing a hand
#
def calculate_handlen(hand):
    """ 
    Returns the length (number of letters) in the current hand.
    
    hand: dictionary (string-> int)
    returns: integer
    """
    
    pass  # TO DO... Remove this line when you implement this function

def play_hand(hand, word_list):

    """
    Allows the user to play the given hand, as follows:

    * The hand is displayed.
    
    * The user may input a word.

    * When any word is entered (valid or invalid), it uses up letters
      from the hand.

    * An invalid word is rejected, and a message is displayed asking
      the user to choose another word.

    * After every valid word: the score for that word is displayed,
      the remaining letters in the hand are displayed, and the user
      is asked to input another word.

    * The sum of the word scores is displayed when the hand finishes.

    * The hand finishes when there are no more unused letters.
      The user can also finish playing the hand by inputing two 
      exclamation points (the string '!!') instead of a word.

      hand: dictionary (string -> int)
      word_list: list of lowercase strings
      returns: the total score for the hand
      
    """
    
    # Keep track of the total score
    totalscore = 0 
    while len(hand) > 0:
    # As long as there are still letters left in the hand:
        # Display the hand
        print("Current Hand: ")
        display_hand(hand)
        # Ask user for input
        try:
            userword = (str(input("Enter word or \"!!\" to indicate that you are finished: ")))
        except ValueError:
            print("Not an string value...")
        if userword == '!!':
            break
        if is_valid_word(userword, hand, word_list):
            wordscore = get_word_score(userword, len(hand))
            totalscore = totalscore + wordscore
            print("\"" + userword + "\"" + " earned " + str(wordscore) + " points. Total: " + str(totalscore) + " points")
        else:
            print("That is not a valid word. Please choose another word.")
        hand = update_hand(hand, userword)
    if len(hand) <= 0:
        print("Ran out of letters. Total Score: " + str(totalscore) + " points.")
    else: 
        print("Total Score: " + str(totalscore) + " points.")
    return totalscore

#
# procedure you will use to substitute a letter in a hand
#

def substitute_hand(hand, letter):
    """ 
    Allow the user to replace all copies of one letter in the hand (chosen by user)
    with a new letter chosen from the VOWELS and CONSONANTS at random. The new letter
    should be different from user's choice, and should not be any of the letters
    already in the hand.

    If user provide a letter not in the hand, the hand should be the same.

    Has no side effects: does not mutate hand.

    For example:
        substitute_hand({'h':1, 'e':1, 'l':2, 'o':1}, 'l')
    might return:
        {'h':1, 'e':1, 'o':1, 'x':2} -> if the new letter is 'x'
    The new letter should not be 'h', 'e', 'l', or 'o' since those letters were
    already in the hand.
    
    hand: dictionary (string -> int)
    letter: string
    returns: dictionary (string -> int)
    """
    replacedhand = copy.deepcopy(hand)
    loops = replacedhand[letter]
    if letter not in hand:
        return hand
    for y in range(0, loops):
        #get random letteruntil letter is one that isn't already in the hand. 
        x = random.choice(VOWELS + CONSONANTS )
        while x in replacedhand:
            x = random.choice(VOWELS + CONSONANTS )
        replacedhand[x] = replacedhand.get(x, 0) + 1
        if replacedhand[letter] > 0:
            replacedhand[letter] -= 1
        if replacedhand[letter] <= 0:
            del replacedhand[letter]
        y += 1 
    return replacedhand
       
def play_game(word_list):
    """
    Allow the user to play a series of hands

    * Asks the user to input a total number of hands

    * Accumulates the score for each hand into a total score for the 
      entire series
 
    * For each hand, before playing, ask the user if they want to substitute
      one letter for another. If the user inputs 'yes', prompt them for their
      desired letter. This can only be done once during the game. Once the
      substitue option is used, the user should not be asked if they want to
      substitute letters in the future.

    * For each hand, ask the user if they would like to replay the hand.
      If the user inputs 'yes', they will replay the hand and keep 
      the better of the two scores for that hand.  This can only be done once 
      during the game. Once the replay option is used, the user should not
      be asked if they want to replay future hands. Replaying the hand does
      not count as one of the total number of hands the user initially
      wanted to play.

            * Note: if you replay a hand, you do not get the option to substitute
                    a letter - you must play whatever hand you just had.
      
    * Returns the total score for the series of hands

    word_list: list of lowercase strings
    """
    handstoplay = 0 
    totalscore = 0
    substused = False
    try: 
        handstoplay = int(input("Enter total number of hands: "))
    except ValueError:
        print("You must inter an integer greater than 0.")

    for n in range (0, handstoplay):
        hand = deal_hand(HAND_SIZE)
        print("Current hand: ")
        display_hand(hand)
        if not substused: 
            subrequest = input("Do you want to substitute a letter? (yes/no): ") 
            if subrequest == 'yes':
                letter = input("Which letter do you want to substitute? ")
                hand = substitute_hand(hand, letter)
        handscore = play_hand(hand, word_list)
        replaygame = input("Do you want to replay this game?(yes/no) ")
        if replaygame == 'yes':
            handscore = play_hand(hand, word_list)
        totalscore = handscore + totalscore
    return totalscore
if __name__ == '__main__':
    word_list = load_words()
    play_game(word_list)
