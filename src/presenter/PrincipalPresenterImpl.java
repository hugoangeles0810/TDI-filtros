/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import service.ImageService;
import service.ImageServiceImpl;
import view.PrincipalView;

/**
 *
 * @author Hugo
 */
public class PrincipalPresenterImpl implements PrincipalPresenter {

    private PrincipalView view;
    private BufferedImage image;
    private ImageService imageService;

    public PrincipalPresenterImpl(PrincipalView view) {
        this.view = view;
        imageService = new ImageServiceImpl();
    }

    @Override
    public void cargarImagen() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter =new FileNameExtensionFilter("Images", "jpg", "png");
        chooser.addChoosableFileFilter(filter);
        chooser.setFileFilter(filter);
        int rpt = chooser.showOpenDialog(view);
        if (rpt == JFileChooser.APPROVE_OPTION) {
            try {
                image = ImageIO.read(chooser.getSelectedFile());
                view.jLabelImage.setIcon(new ImageIcon(image));
            } catch (IOException ex) {
                Logger.getLogger(PrincipalView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void aplicarFiltro(int opcion) {
        BufferedImage filterImage;

        if (image == null) {
            JOptionPane.showMessageDialog(view, "Debe seleccionar una imagen.");
            return;
        }

        switch (opcion) {
            case FILTRO_NEGATIVO:
                filterImage = imageService.filtroNegativo(image);
                view.jLabelFilter.setIcon(new ImageIcon(filterImage));
                break;
            case FILTRO_LOGARITMICO:
                double alfaLog = Double.parseDouble(view.jSpinnerAlfaLog.getValue().toString());
                filterImage = imageService.filtroLogaritmico(image, alfaLog);
                view.jLabelFilter.setIcon(new ImageIcon(filterImage));
                break;
            case FILTRO_SENO:
                filterImage = imageService.filtroSeno(image);
                view.jLabelFilter.setIcon(new ImageIcon(filterImage));
                break;
            case FILTRO_COSENO:
                filterImage = imageService.filtroCoseno(image);
                view.jLabelFilter.setIcon(new ImageIcon(filterImage));
                break;
            case FILTRO_EXPONENCIAL:
                double alfaExp = Double.parseDouble(view.jSpinnerAlfaExp.getValue().toString());
                filterImage = imageService.filtroExponencial(image, alfaExp);
                view.jLabelFilter.setIcon(new ImageIcon(filterImage));
                break;
            case FILTRO_SIGMOIDE:
                double landaSig = Double.parseDouble(view.jSpinnerLandaSig.getValue().toString());
                filterImage = imageService.filtroSigmoide(image, landaSig);
                view.jLabelFilter.setIcon(new ImageIcon(filterImage));
                break;
            default:
                break;
        }
    }
}
