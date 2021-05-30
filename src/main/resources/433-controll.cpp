#include "../rc-switch/RCSwitch.h"
#include <stdlib.h>
#include <stdio.h>
#include <string>

class LightGroup433
{
public:
    int id;
    int on;
    int off;
    int colorCold;
    int colorNormal;
    int colorWarm;
    int lightBrighter;
    int lightDarker;
};

int main(int argc, char *argv[])
{
    int PIN = 0;

    LightGroup433 group1;
    group1.id = 1;
    group1.on = 4457809;
    group1.off = 4457812;
    group1.colorCold = 0;
    group1.colorNormal = 0;
    group1.colorWarm = 0;
    group1.lightBrighter = 0;
    group1.lightDarker = 0;

    LightGroup433 group2;
    group2.id = 2;
    group2.on = 4460881;
    group2.off = 4460884;
    group2.colorCold = 0;
    group2.colorNormal = 0;
    group2.colorWarm = 0;
    group2.lightBrighter = 0;
    group2.lightDarker = 0;

    LightGroup433 group3;
    group3.id = 3;
    group3.on = 4682753;
    group3.off = 4682755;
    group3.colorCold = 4682759;
    group3.colorNormal = 4682760;
    group3.colorWarm = 4682761;
    group3.lightBrighter = 4682756;
    group3.lightDarker = 4682758;

    LightGroup433 selectedGroup;

    if (wiringPiSetup() == -1)
        return 1;

    RCSwitch mySwitch = RCSwitch();
    mySwitch.enableTransmit(PIN);

    // Gruppe wählen
    if (atoi(argv[1]) == 1)
    {
        selectedGroup = group1;
    }
    else if (atoi(argv[1]) == 2)
    {
        selectedGroup = group2;
    }
    else
    {
        selectedGroup = group3;
    }

    // Optionen
    if (argv[2] == std::string("on"))
    {
        mySwitch.send(selectedGroup.on, 24);
    }
    else if (argv[2] == std::string("off"))
    {
        mySwitch.send(selectedGroup.off, 24);
    }
    else if (argv[2] == std::string("cold"))
    {
        mySwitch.send(selectedGroup.colorCold, 24);
    }
    else if (argv[2] == std::string("normal"))
    {
        mySwitch.send(selectedGroup.colorNormal, 24);
    }
    else if (argv[2] == std::string("warm"))
    {
        mySwitch.send(selectedGroup.colorWarm, 24);
    }
    else if (argv[2] == std::string("brighter"))
    {
        mySwitch.send(selectedGroup.lightBrighter, 24);
        mySwitch.send(selectedGroup.lightBrighter, 24);
        mySwitch.send(selectedGroup.lightBrighter, 24);
        mySwitch.send(selectedGroup.lightBrighter, 24);
        mySwitch.send(selectedGroup.lightBrighter, 24);
    }
    else if (argv[2] == std::string("darker"))
    {
        mySwitch.send(selectedGroup.lightDarker, 24);
        mySwitch.send(selectedGroup.lightDarker, 24);
        mySwitch.send(selectedGroup.lightDarker, 24);
        mySwitch.send(selectedGroup.lightDarker, 24);
        mySwitch.send(selectedGroup.lightDarker, 24);
    }
    return 0;
}