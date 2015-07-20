/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

/**
 *
 * @author Hugo
 */
public interface PrincipalPresenter {
    
    public static final int FILTRO_NEGATIVO = 1;
    public static final int FILTRO_LOGARITMICO = 2;
    public static final int FILTRO_SENO = 3;
    public static final int FILTRO_COSENO = 4;
    public static final int FILTRO_EXPONENCIAL = 5;
    public static final int FILTRO_SIGMOIDE = 6;
    
    public void cargarImagen();
    
    public void aplicarFiltro(int opcion);
    
}
