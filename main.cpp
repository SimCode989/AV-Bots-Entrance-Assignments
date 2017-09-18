#include <iostream>

#include "pid.hpp"

double PID = 0;

double computePID(){
	return 0;
}

int main()
{
    double desiredHeight;
    std::cout << "Desired Height: ";
    std::cin >> desiredHeight;

    /*
     * Code should start here.
     */
    double error = 0;
    double prevError = 0;
    int time = 0;
    double height = 0;

    double Proportional = 0;
    double Integral = 0;
    double Derivative = 0;

     while (1){
 
        height = getHeight();
        error = desiredHeight - height;
        if (time == 0){
            prevError = error;
        }

        Proportional = KP * error;
        Integral = Integral + KI * error;
        Derivative = error - prevError;
        PID = Proportional + Integral + Derivative;
        setThrust(PID);
        std::cout << "The height at " << time <<" " << "was " << height << std::endl;
        std::cout << "PID was " << PID << std::endl;

        time++;
        prevError = error;
     }
}