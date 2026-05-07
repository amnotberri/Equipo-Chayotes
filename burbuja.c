class Burbuja : public Ordenador {
public:
    Burbuja(vector<int> d) : Ordenador(d) {}

    void ordenar() override {
        int n = datos.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (datos[j] > datos[j+1]) {
                    swap(datos[j], datos[j+1]);
                }
            }
        }
    }
};
