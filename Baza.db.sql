BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Bus" (
	"bus_id"	INTEGER,
	"proizvodjac"	TEXT,
	"serija"	TEXT,
	"broj_sjedista"	INTEGER,
	"broj_vozaca"	INTEGER,
	PRIMARY KEY("bus_id")
);
CREATE TABLE IF NOT EXISTS "Vozac" (
	"vozac_id"	INTEGER,
	"ime"	TEXT,
	"prezime"	TEXT,
	"JMB"	TEXT,
	"datum_rodjenja"	DATE,
	"datum_zaposljenja"	DATE,
	PRIMARY KEY("vozac_id")
);
COMMIT;
