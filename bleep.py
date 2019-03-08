import sys, getopt

def main():
    #read the commandline arguments and do checking
    fullCmdArguments = sys.argv
    argumentList = fullCmdArguments[1:]
    if len(sys.argv) != 2:
        print("Usage: python3 bleep.py filename")
        sys.exit(1)
    try:
        values = getopt.getopt(argumentList, "")
    except getopt.error as err:
        # output error, and return with an error code
        print (str(err))
        sys.exit(1)
    # function to open the file and put the words in the file in a set 
    def loadfile(filename):
        bwordslist = set()
        file = open(filename, "r")
        for line in file:
            bwordslist.add(line.rstrip("\n"))
        file.close()
        return bwordslist
    def getuserinput(): 
        while True:
            try:
                return str(input("Please enter a string: "))
            except ValueError:
                print("Not an string...")
    def bleepuserstring(inputstring, stringsdict):
        wordslist = (inputstring.split(' '))
        #check the list you just created against the stringsdict  list
        for i in range(len(wordslist)):
            if wordslist[i].lower() in stringsdict:
                #replace the wordslist[i] with * for each letter
                rword = wordslist[i]
                bleepnumber = len(rword)
                rword = ''
                for k in range(bleepnumber):
                    rword =  rword + '*'
                wordslist[i] = rword
        s = " "
        return s.join(wordslist)
    bwords = loadfile(argumentList[0])
    strentered = getuserinput() 
    bleepedstring = bleepuserstring(strentered, bwords)
    print(bleepedstring)
if __name__ == "__main__":
    main()
