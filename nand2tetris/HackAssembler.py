from Parser import constructor, commandType, dest, comp, jump

def main():
    #Get list of lines from file loaded in commandline argument
    assemblylines = constructor()
    assemblylines_nocomments=[]
    converted_assembly=[]
    #Replace comments with white space, remove spaces.
    for line in assemblylines:
        line = line.split("//", 1)[0]
        line = line.replace(" ", "")
        assemblylines_nocomments.append(line)
    #Remove blank lines.
    assemblylines_nocomments = list(filter(None, assemblylines_nocomments))
    #convert lines to binary
    for line in assemblylines_nocomments:
        cmdtype =  commandType(line)
        if cmdtype == "A_COMMAND":
            line = int(line[1:])
            binary_number = "{0:015b}".format(line)
            binary_a_line = '0' + str(binary_number) 
            converted_assembly.append(binary_a_line)
        elif cmdtype == "C_COMMAND":
            if "=" in line:
                d, compjump = line.split("=",1)
                destline = dest(d)
            if ";" in line:
                c, j = line.split(";",1)
                jumpline = jump(j)
                binary_c_line = '111' + comp(c) + '000'+ jump(j)
            else:
                binary_c_line = '111' + comp(compjump) + destline + jump('null')
            converted_assembly.append(binary_c_line)
    for blines in converted_assembly:
        print(blines)
if __name__ == "__main__":
    main()
