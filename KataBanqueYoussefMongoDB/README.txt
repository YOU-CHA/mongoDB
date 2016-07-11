Une fois le POC démarré vous pouvez utiliser PostMan comme client REST afin d’exécuter les liens ci-dessous dans l'ordre

Lien 1 : Add Client :
 
 	Méthode : POST
	Link http://localhost:8080/api/clients
	
	JSON : => {"nomClient":"youssef"}
	
	{
		"seq": 1,
		"nomClient": "youssef",
		"comptes": []
	}

Lien 2 : add Compte to Client
  
  Méthode POST
  Link : http://localhost:8080/api/comptes/1
  
  JSON => {"codeCompte":"CC1","solde":"50000" , "TYPE_CPTE":"CC","decouvert":"70000"}
  Resultat
{
  "seq": 1,
  "nomClient": "youssef",
  "comptes": [
    {
      "TYPE_CPTE": "CC",
      "codeCompte": "CC1",
      "dateCreation": 1468185993683,
      "solde": 50000,
      "operations": [],
      "decouvert": 70000
    }
  ]
}

Lien 3 : RETRAIT

	Méthode PUT
	Link : http://localhost:8080/api/operations/1/comptes/CC1/retrait/8000

	Resultat :
	
{
  "seq": 1,
  "nomClient": "youssef",
  "comptes": [
    {
      "TYPE_CPTE": "CC",
      "codeCompte": "CC1",
      "dateCreation": 1468185993683,
      "solde": 42000,
      "operations": [
        {
          "TYPE_OP": "R",
          "numeroOperation": 1,
          "dateOperation": 1468186028153,
          "montant": 8000
        }
      ],
      "decouvert": 70000
    }
  ]
}
}
Lien 4 : VERSEMENT
	
	Méthode : PUT
	Link : http://localhost:8080/api/operations/1/comptes/CC1/versement/785985

{
  "seq": 1,
  "nomClient": "youssef",
  "comptes": [
    {
      "TYPE_CPTE": "CC",
      "codeCompte": "CC1",
      "dateCreation": 1468185993683,
      "solde": 827985,
      "operations": [
        {
          "TYPE_OP": "R",
          "numeroOperation": 1,
          "dateOperation": 1468186028153,
          "montant": 8000
        },
        {
          "TYPE_OP": "V",
          "numeroOperation": 2,
          "dateOperation": 1468186110595,
          "montant": 785985
        }
      ],
      "decouvert": 70000
    }
  ]
}

Lien 5 : Liste des operation d'un compe pour un client donn�
		http://localhost:8080/api/operations/1/comptes/CC1/

Resultat
[
  {
    "TYPE_OP": "R",
    "numeroOperation": 1,
    "dateOperation": 1468186028153,
    "montant": 8000
  },
  {
    "TYPE_OP": "V",
    "numeroOperation": 2,
    "dateOperation": 1468186110595,
    "montant": 785985
  }
]


