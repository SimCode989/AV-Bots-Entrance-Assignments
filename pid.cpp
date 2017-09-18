#include <iostream>

#include "pid.hpp"


/*
 * Just taking user input for height, not an actual implementation
 */
double getHeight()
{
    double height;
	std::cout << "Input current height:";
    std::cin >> height;
    return height;
}

/*
 * Does nothing, not an actual implementation
 */
void setThrust(double thrust)
{

}