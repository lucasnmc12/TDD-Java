package classes;

public class Relogio {
    private int hora;     // De 0 a 23
    private int minuto;   // De 0 a 59
    private int segundo;  // De 0 a 59

    public Relogio(int hora, int minuto, int segundo) {
        validarTempo(hora, minuto, segundo);
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public void setHora(int hora) {
        validarHora(hora);
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        validarMinuto(minuto);
        this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        validarSegundo(segundo);
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    private void validarTempo(int hora, int minuto, int segundo) {
        if (!(hora >= 0 && hora < 24 && minuto >= 0 && minuto < 60 && segundo >= 0 && segundo < 60)) {
            throw new IllegalArgumentException("Valores inválidos para hora, minuto ou segundo.");
        }
    }

    private void validarHora(int hora) {
        if (!(hora >= 0 && hora < 24)) {
            throw new IllegalArgumentException("Hora inválida.");
        }
    }

    private void validarMinuto(int minuto) {
        if (!(minuto >= 0 && minuto < 60)) {
            throw new IllegalArgumentException("Minuto inválido.");
        }
    }

    private void validarSegundo(int segundo) {
        if (!(segundo >= 0 && segundo < 60)) {
            throw new IllegalArgumentException("Segundo inválido.");
        }
    }
    public void aumentarMinuto(int minutos) {
        if (minutos < 0) {
            throw new IllegalArgumentException("Número de minutos deve ser positivo.");
        }

        int totalMinutos = hora * 60 + minuto + minutos;
        int novaHora = totalMinutos / 60;
        int novoMinuto = totalMinutos % 60;

        if (novaHora >= 24) {
            novaHora %= 24;
        }

        this.hora = novaHora;
        this.minuto = novoMinuto;
    }
    public void aumentarHora(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Número de horas deve ser positivo.");
        }

        int totalHoras = hora + horas;
        int novaHora = totalHoras % 24;

        this.hora = novaHora;
    }

  
}
