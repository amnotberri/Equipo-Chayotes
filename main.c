int main() {
    vector<int> numeros = {5, 2, 9, 1, 3};

    Burbuja b(numeros);
    b.ordenar();

    cout << "Ordenado Burbuja: ";
    b.mostrar();

    return 0;
}
