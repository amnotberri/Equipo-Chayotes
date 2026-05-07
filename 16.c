#include <iostream>
#include <vector>
using namespace std;

// NUEVO TIPO DE DATO
class Alumno {
public:
    string nombre;
    int edad;

    Alumno(string n, int e) {
        nombre = n;
        edad = e;
    }
};
