import sys

# Input File -> List
# Opens input file/stream, places lines into list and returns list
def constructor():
    with open(sys.argv[1], 'r') as my_file:
        assemblylines = my_file.readlines()
    assemblylines = [x.strip() for x in assemblylines] 
    return assemblylines

# Nothing -> Boolean
# Are there more commands in the input?
# Assuming this function will not be needed.
def hasMoreCommands():
    return True

# Nothing -> Nothing
# Reads the next command from the input and makes it
# the current command. Should be called only if the
# if hasMoreCommands() is true. Intitially there is
# no current command.
def advance():
    return null

# String -> Strint (Command)
# Returns the type of the current command.
def commandType(line):
    if line[0] == '@':
        return "A_COMMAND"
    else:
        return "C_COMMAND"

# Nothing -> String
# Returns the symbol of decimal Xxx of current command @
# or (Xxx). Should be called only when commandType() is 
# A_COMMAND or L_COMMAND
def symbol():
    return string

# String -> String
# Returns dest mnemonic in the current C-command
# (8 possibilities). Should be called only when 
# commandType() is C_COMMAND
def dest(mnemonic):
    dest_options ={'null':'000',
                   'M':'001',
                   'D':'010',
                   'MD':'011',
                   'A':'100',
                   'AM':'101',
                   'AD':'110',
                   'AMD':'111'
                  }
    return dest_options[mnemonic]

# Nothing -> String
#Returns the comp mnemonic in the current C-command
# (28 possibilities). Should be called only when
# the commandType() is C_COMMAND
def comp(mnemonic):
    comp_options ={'0':'0101010',
                   '1':'0111111',
                   '-1':'0111010',
                   'D':'0001100',
                   'A':'0110000',
                   '!D':'0001101',
                   '!A':'0110001',
                   '-D':'0001111',
                   '-A':'0110011',
                   'D+1':'0011111',
                   'A+1':'0110111',
                   'D-1':'0001110',
                   'A-1':'0110010',
                   'D+A':'0000010',
                   'D-A':'0010011',
                   'A-D':'0000111',
                   'D&A':'0000000',
                   'D|A':'0010101',
                   'M':'1110000',
                   '!M':'1110001',
                   'M+1':'1110111',
                   'D+M':'1000010',
                   'D-M':'1010011',
                   'M-D':'1000111',
                   'D&M':'1000000',
                   'D|M':'1010101'
                  }
    return comp_options[mnemonic]

# Nothing -> String
# Returns the jump mnemonic in the current C-command
# (8 possibilities). Should be called only when the
# commandType() is C_COMMAND
def jump(mnemonic):
    jump_options ={'null':'000',
                  'JGT':'001',
                  'JEQ':'010',
                  'JGE':'011',
                  'JLT':'100',
                  'JNE':'101',
                  'JLE':'110',
                  'JMP':'111'
                 }
    return jump_options[mnemonic] 
