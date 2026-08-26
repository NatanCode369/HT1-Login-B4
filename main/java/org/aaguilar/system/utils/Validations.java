package org.aaguilar.system.utils;

public class Validations {
    public Validations() {
    }

    public boolean validarTelefono(String telefono) {
        try {
            Integer.parseInt(telefono);
            //Acá debe ir la alerta.
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public boolean validarCorreo(String email) {
        int countArrobe = 0;
        int indexArrobe = -1;
        int countPeriod = 0;

        for (int i = 0 ; i < email.length() ; i++){
            if (email.charAt(i) == '@') {
                countArrobe++;
                indexArrobe = i;

            } else if (email.charAt(indexArrobe) == '.' && indexArrobe != -1 && i > indexArrobe + 1) countPeriod++;
        }
        return countArrobe == 1 && (countPeriod >= 1 && countPeriod <= 2);
    }
}
