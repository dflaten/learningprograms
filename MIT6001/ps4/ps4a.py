# Problem Set 4A
# Got stuck on this one so looked up several solutions and worked out how they solved the problem
def get_permutations(string):
    permutation_list = []
    if len(string) == 1:
        return [string]
    else:
        for char in string:
            [permutation_list.append(char + a) for a in get_permutations(string.replace(char, ""))]
    return permutation_list

def f(s):
    if len(s) == 2:
        X = [s, (s[1] + s[0])]
        return X
    else:
        list1 = []
        for i in range(0, len(s)):
            Y = f(s[0:i] + s[i+1: len(s)])
            for j in Y:
                list1.append(s[i] + j)
        return list1
if __name__ == '__main__':
    #EXAMPLE
    example_input = 'abc'
    print('Input:', example_input)
    print('Expected Output:', ['abc', 'acb', 'bac', 'bca', 'cab', 'cba'])
    print('Actual Output:', get_permutations_onechar(example_input))
    s = 'abc'
    print('Input:', s)
    print('Expected Output:', ['abc', 'acb', 'bac', 'bca', 'cab', 'cba'])
    print('Actual Output:', f(s))
'''
Possible solutions to this problem include: 
    1) get_permutations_onechar - recursing the string down to one character for every character in the string
    and adding it to the list, 
    2) f - take the first character off of the string and then recursively split the string into two haves until you get down to a string length of 2. Then return a list
    with the original string and the reverse of that string. The strings are then rebuilt and added to the list. 
'''

