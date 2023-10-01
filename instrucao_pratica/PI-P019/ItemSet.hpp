#if !defined(ITEMSET_HPP)
#define ITEMSET_HPP

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class ItemSet {
    vector<string> items;

    public:

        ItemSet(){

        }

        ItemSet& operator=(ItemSet& novo) {
            if (this != &novo) {
                items = novo.items;
            }
            return *this;
        }

        ItemSet operator+(ItemSet& item){
            ItemSet novo(*this);

            for (string& i : item.items) {
                bool itemExiste = false;
                for (string& it : novo.items) {
                    if (i == it) {
                        it = true;
                        break;
                    }
                }
                if (!itemExiste) {
                    novo.items.push_back(i);
                }
            }

            return novo;
        }

        ItemSet operator*(ItemSet& _item) {
            ItemSet novo;

            for (string& item : items) {
                if (_item.contem(item)) {
                    novo.inserir(item);
                }
            }

            return novo;
        }

        ItemSet operator-(ItemSet& _item) {
            ItemSet novo;

            for (string& item : items) {
                if (!_item.contem(item)) {
                    novo.inserir(item);
                }
            }

            return novo;
        }

        ItemSet operator%(ItemSet& _item) {
            ItemSet delta;

            for (string& item : items) {
                if (!_item.contem(item)) {
                    delta.inserir(item);
                }
            }

            for (string& item : _item.items) {
                if (!contem(item)) {
                    delta.inserir(item);
                }
            }

            return delta;
        }

        bool operator==(ItemSet& _item) {
            for (string& item : items) {
                if (!_item.contem(item)) {
                    return false;
                }
            }

            for (string& item : _item.items) {
                if (!contem(item)) {
                    return false;
                }
            }

            return true;
        }
        
        void inserir(string s) {
            for (const string item : items) {
                if (item == s) {
                    cout << "Item '" << s << "' já existe no conjunto." << endl;
                    return; 
                }
            }
            
            items.push_back(s);
            cout << "Item '" << s << "' inserido com sucesso." << endl;
            return;
        }

        void excluir(const string s) {
            for (auto it = items.begin(); it != items.end(); ++it) {
                if (*it == s) {
                    items.erase(it);
                    cout << "Item '" << s << "' excluído com sucesso." << endl;
                    return;
                }
            }
            
            cout << "Item '" << s << "' não encontrado no conjunto." << endl;
        }

        bool contem(string& s) {
            for (string& item : items) {
                if (item == s) {
                    return true;
                }
            }
            return false;
        }

        void listarItens() {
            cout << "Itens no conjunto:" << endl;
            for (const string item : items) {
                cout << item << endl;
            }
        }
};

#endif // ITEMSET_HPP
