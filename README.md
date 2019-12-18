# Estelle Héripret - Master E-Services 

## IFI Pokemon

### TP4 trainer-api

Implémentation de la création, de la mise à jour, de la suppression
et de la récupération d'un Trainer.
L'API est sécurisée en HTTP via un login et un mot de passe.

Requètes :

- Récupération de tous les trainers.
    
        GET /trainers

- Récupération d'un trainer avec son nom

        GET /trainers/Ash
        
- Création d'un nouveau trainer

        POST /trainers/
        {
          "name": "Bug Catcher",
          "team": [
            {"pokemonType": 13, "level": 6},
            {"pokemonType": 10, "level": 6}
          ]
        }

- Modification d'un trainer

        PUT /trainers/
        {
          "name": "Bug Catcher",
          "team": [
            {"pokemonType": 13, "level": 6},
            {"pokemonType": 10, "level": 6}
          ]
        }

- Suppression d'un trainer

        DELETE /trainers/Ash