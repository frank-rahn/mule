        01 DFHCOMMAREA.
          05 RESULT.
              10 FEHLERCODE          PIC X(02).
              10 FEHLERTEXT          PIC X(72).
              10 SQLCODE             PIC S9(5) BINARY.
          05 AUSGABE.
            07 BANK                  OCCURS 15.
              10 NAME                PIC X(30).
              10 BLZ                 PIC X(08).
              10 PLZ                 PIC X(05).
              10 ORT                 PIC X(30).
              10 BIC                 PIC X(11).
              