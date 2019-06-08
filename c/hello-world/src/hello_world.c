#include "hello_world.h"
#include <stdio.h>

const char *hello(void)
{
    static char hello[] = "Hello, World!";
    return hello;
}
