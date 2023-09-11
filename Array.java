import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Array {

 private static ArrayList<String> playlist = new ArrayList<>();

    public static void main(String[] args) {
        boolean salirDelPrograma = false;
        while (!salirDelPrograma) {
            int opcion = menu();

            switch (opcion) {
                case 1:
                    agregarCancion();
                    break;
                case 2:
                    verCanciones();
                    break;
                case 3:
                    eliminarPlaylist();
                    break;
                case 4:
                    actualizarPlaylist();
                    break;
                case 5:
                    int confirmar = JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "Confirma la salida del programa", JOptionPane.YES_NO_OPTION);
                    if (confirmar == JOptionPane.YES_OPTION) {
                        salirDelPrograma = true;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa.");
    }

    public static int menu() {
        String[] opciones = {"Agregar canción", "Ver canciones", "Eliminar playlist", "Actualizar playlist", "Salir"};
        return JOptionPane.showOptionDialog(null, "Selecciona la opción", "Menú", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]) + 1;
    }

    public static void agregarCancion() {
        String cancion = JOptionPane.showInputDialog("Agregar nombre de la canción: ");
        if (cancion != null && !cancion.isEmpty()) {
            playlist.add(cancion);
            JOptionPane.showMessageDialog(null, "Canción agregada: " + cancion);
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de canción inválido");
        }
    }

    public static void verCanciones() {
        if (playlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La playlist está vacía");
        } else {
            Collections.sort(playlist);
            StringBuilder canciones = new StringBuilder();

            for (String cancion : playlist) {
                canciones.append(cancion).append("\n");
            }

            JOptionPane.showMessageDialog(null, canciones.toString(), "Canciones en la playlist", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void eliminarPlaylist() {
        int confirmar = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar la playlist?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            playlist.clear();
            JOptionPane.showMessageDialog(null, "Playlist eliminada");
        }
    }

    public static void actualizarPlaylist() {
        verCanciones();

        String cancion = JOptionPane.showInputDialog(null, "Ingrese el nombre de la canción a actualizar");
        if (cancion != null && !cancion.isEmpty()) {
            int indice = buscarCancion(cancion);

            if (indice != -1) {
                String nuevaCancion = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de la canción");
                if (nuevaCancion != null && !nuevaCancion.isEmpty()) {
                    playlist.set(indice, nuevaCancion);
                    JOptionPane.showMessageDialog(null, "Canción actualizada exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de canción inválido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La canción no existe en la playlist");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de canción inválido");
        }
    }

    public static int buscarCancion(String cancion) {
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).equalsIgnoreCase(cancion)) {
                return i;
            }
        }
        return -1;
    }
}
   