class Ordenador : public IOrdenamiento {
protected:
    vector<int> datos;
public:
    Ordenador(vector<int> d) : datos(d) {}
    virtual void ordenar() = 0;

    void mostrar() {
        for (int x : datos) cout << x << " ";
        cout << endl;
    }
};
