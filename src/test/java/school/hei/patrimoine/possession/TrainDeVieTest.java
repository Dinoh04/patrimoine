package school.hei.patrimoine.possession;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainDeVieTest {
  @Test
  void train_de_vie_est_finance_par_compte_courant() {
    var au13mai24 = Instant.parse("2024-05-13T00:00:00.00Z");
    var compteCourant = new Argent("Compte courant", au13mai24, 600_000);

    var aLOuvertureDeHEI = Instant.parse("2021-10-26T00:00:00.00Z");
    var aLaDiplomation = Instant.parse("2024-12-26T00:00:00.00Z");
    var vieEstudiantine =
            new TrainDeVie(
                    "Ma super(?) vie d'etudiant",
                    500_000,
                    aLOuvertureDeHEI,
                    aLaDiplomation,
                    compteCourant,
                    1);

    var au13juin24 = Instant.parse("2024-06-13T00:00:00.00Z");
    //TODO: assert something useful
    assertEquals(compteCourant, vieEstudiantine.getFinancePar());
    assertEquals(100_000, compteCourant.getValeurComptable() - vieEstudiantine.getDepensesMensuelle());
    assertEquals(
            100_000, vieEstudiantine.projectionFuture(au13juin24).getFinancePar().valeurComptable);
  }

  @Test
  void un_train_de_vie_financé_par_argent() {
    var au13mai24 = Instant.parse("2024-05-13T00:00:00.00Z");
    var financeur = new Argent("Espèces", au13mai24, 400_000);

    var trainDeVie = new TrainDeVie(null, 0, null, null, financeur, 0);
  }
}