INSERT INTO Client (EMAIL, NOM, PRENOM)
VALUES
    ('mail1', 'nom1', 'prenom1'),
    ('mail2', 'nom2', 'prenom2'),
    ('mail3', 'nom3', 'prenom3');

INSERT INTO COMPTE (DECOUVERT, NUM_COMPTE, SOLDE, PLAFOND, CLIENT_ID)
VALUES
    (500, 23, 5.5, 2000, 1),
    (5, 28, 2, 5000, 3),
    (30, 12, 20, 1500, 2);

INSERT INTO OPERATION (TYPE, MONTANT, COMPTE_ID)
VALUES
    ('debit', 20, 1),
    ('gain', 15, 1),
    ('debit', 8, 2);