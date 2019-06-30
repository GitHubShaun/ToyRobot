echo "ToyRobot Library Simulation Compiling, by Shaun Chua\n..."
javac -d . -cp ".:lib/ToyRobot.jar" src/toyrobot/ToyRobotSim.java
if [ $# -eq 0 ]
then
    echo "No arguments provided.\nUsage: sh testscript.sh [filename.txt] [filename.txt]"
else
    for i in "$@"
    do
        java -cp "lib/ToyRobot.jar" toyrobot.ToyRobotSim testfiles/$i
    done
fi
echo "...\nCompleted."
