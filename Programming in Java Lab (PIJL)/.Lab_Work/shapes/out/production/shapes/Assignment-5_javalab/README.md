# Shape Calculator

## Description
This Java-based Shape Calculator allows users to compute the area, perimeter, and volume of various 2D and 3D shapes. It utilizes Object-Oriented Programming (OOP) principles such as abstraction, inheritance, and interfaces.

The program supports:
- 2D Shapes: Triangle, Rectangle, Square, Circle
- 3D Shapes: Cube, Sphere, Cylinder, Equilateral Pyramid
- Menu-driven user interaction for ease of use

---
## Prerequisites
Before running this program, ensure you have the following:
- **Java Development Kit (JDK) 8 or later** installed on your system
- **An IDE or text editor** (e.g., IntelliJ IDEA, Eclipse, VS Code, or Notepad++)
- **Command line or terminal access** to compile and run Java programs

1. To check if Java is installed, run the following command:
   ```sh
   java -version


## Files & Classes Overview

### Shape.java
Defines an abstract base class for all shapes, providing common attributes and abstract methods.

### VolumeInterface.java
Defines an interface for 3D shapes that calculates volume.

### Shape Implementations
These classes extend Shape and implement VolumeInterface where applicable:
- Triangle.java (extends Shape)
- Rectangle.java (extends Shape)
- Square.java (extends Shape)
- Circle.java (extends Shape)
- Cube.java (extends Shape, implements VolumeInterface)
- Sphere.java (extends Shape, implements VolumeInterface)
- Cylinder.java (extends Shape, implements VolumeInterface)
- EquilateralPyramid.java (extends Shape, implements VolumeInterface)

### Main.java
Contains the menu-driven program to interact with users and perform calculations.

---

## Classes & Methods

### Shape.java
| Method | Description |
|--------|------------|
| `Shape()` | Default constructor initializing dimensions to zero. |
| `Shape(double dim_one, double dim_two, double dim_three, int num_sides)` | Parameterized constructor for shape initialization. |
| `calculateArea()` | Abstract method for calculating area. |
| `calculatePerimeter()` | Abstract method for calculating perimeter. |
| `getNumSides()` | Returns the number of sides of the shape. |

### VolumeInterface.java
| Method | Description |
|--------|------------|
| `calculateVolume()` | Abstract method for calculating volume (implemented by 3D shapes). |

### Shape Implementations
Each class extends Shape and implements its respective formulas.

#### Triangle.java
| Method | Description |
|--------|------------|
| `Triangle(double base, double height)` | Constructor initializing base and height. |
| `calculateArea()` | Computes area: `0.5 * base * height`. |
| `calculatePerimeter()` | Computes perimeter using Pythagoras theorem. |

#### Rectangle.java
| Method | Description |
|--------|------------|
| `Rectangle(double length, double breadth)` | Constructor initializing length and breadth. |
| `calculateArea()` | Computes area: `length * breadth`. |
| `calculatePerimeter()` | Computes perimeter: `2 * (length + breadth)`. |

#### Square.java
| Method | Description |
|--------|------------|
| `Square(double side)` | Constructor initializing side. |
| `calculateArea()` | Computes area: `side * side`. |
| `calculatePerimeter()` | Computes perimeter: `4 * side`. |

#### Circle.java
| Method | Description |
|--------|------------|
| `Circle(double radius)` | Constructor initializing radius. |
| `calculateArea()` | Computes area: `π * radius²`. |
| `calculatePerimeter()` | Computes circumference: `2 * π * radius`. |

#### Cube.java
| Method | Description |
|--------|------------|
| `Cube(double side)` | Constructor initializing side. |
| `calculateArea()` | Computes surface area: `6 * side²`. |
| `calculatePerimeter()` | Computes perimeter: `12 * side`. |
| `calculateVolume()` | Computes volume: `side³`. |

#### Sphere.java
| Method | Description |
|--------|------------|
| `Sphere(double radius)` | Constructor initializing radius. |
| `calculateArea()` | Computes surface area: `4 * π * radius²`. |
| `calculatePerimeter()` | Computes circumference: `2 * π * radius`. |
| `calculateVolume()` | Computes volume: `(4/3) * π * radius³`. |

#### Cylinder.java
| Method | Description |
|--------|------------|
| `Cylinder(double radius, double height)` | Constructor initializing radius and height. |
| `calculateArea()` | Computes surface area: `2 * π * radius * (radius + height)`. |
| `calculatePerimeter()` | Computes perimeter: `2 * (2 * radius + height)`. |
| `calculateVolume()` | Computes volume: `π * radius² * height`. |

#### EquilateralPyramid.java
| Method | Description |
|--------|------------|
| `EquilateralPyramid(double side, double height)` | Constructor initializing side and height. |
| `calculateArea()` | Computes surface area using pyramid formula. |
| `calculatePerimeter()` | Computes perimeter: `4 * side`. |
| `calculateVolume()` | Computes volume: `(1/3) * base_area * height`. |

### Main.java (Menu-Driven Program)
Allows users to choose a shape and calculate area, perimeter, and volume.

| Option | Description |
|--------|------------|
| 1 | Compute area and perimeter of a Triangle. |
| 2 | Compute area and perimeter of a Rectangle. |
| 3 | Compute area, perimeter, and volume of a Cube. |
| 4 | Compute area and perimeter of a Square. |
| 5 | Compute area and perimeter of a Circle. |
| 6 | Compute area, perimeter, and volume of a Sphere. |
| 7 | Compute area, perimeter, and volume of a Cylinder. |
| 8 | Compute area, perimeter, and volume of an Equilateral Pyramid. |
| 9 | Exit the program. |

---

## How to Run the Program
1. Compile all `.java` files:
   ```sh
   javac Main.java
2. Run the program:
   ```sh
   java Main
