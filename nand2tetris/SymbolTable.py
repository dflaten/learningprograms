#Creates a new empty symbol table
class SymbolTable:

    def __init__(self):
        SymbolTable.symboDict = {'SP':0,
                                 'LCL':1,
                                 'ARG':2,
                                 'THIS':3,
                                 'THAT':4,
                                 'R0':}

    #String, int->void
    #Adds the pair (symbol(String), address(int)) to the table. 
    def addEntry(symbol, address):
        SymbolTable.symbolDict[symbol, address]

    #String->Boolean
    #Does the symbol table contain the given symbol?
    def contains(symbol):
        if symbol in SymbolTable.symbolDict:
            return True
        else:
            return False
    #String->int
    #Returns the address(int) asociated with the symbol(string).
    def GetAddress(symbol):
        return SymbolTable.symbolDict[symbol]
