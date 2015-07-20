/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hugo
 */
public class ImageServiceImpl implements ImageService {

    @Override
    public BufferedImage filtroNegativo(BufferedImage image) {
        BufferedImage filter = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < filter.getWidth(); i++) {
            for (int j = 0; j < filter.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                r = L - r;
                g = L - g;
                b = L - b;

                filter.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }
        return filter;
    }

    @Override
    public BufferedImage filtroLogaritmico(BufferedImage image, double alfa) {
        BufferedImage filter = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        double A = L / (Math.log(alfa * L + 1));
        for (int i = 0; i < filter.getWidth(); i++) {
            for (int j = 0; j < filter.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                r = operarLogaritmo(A, alfa, r);
                g = operarLogaritmo(A, alfa, g);
                b = operarLogaritmo(A, alfa, b);

                filter.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }
        return filter;
    }

    @Override
    public BufferedImage filtroSeno(BufferedImage image) {
        BufferedImage filter = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < filter.getWidth(); i++) {
            for (int j = 0; j < filter.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                r = operarSeno(r);
                g = operarSeno(g);
                b = operarSeno(b);

                filter.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }
        return filter;
    }
    
    @Override
    public BufferedImage filtroCoseno(BufferedImage image) {
        BufferedImage filter = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < filter.getWidth(); i++) {
            for (int j = 0; j < filter.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                r = operarCoseno(r);
                g = operarCoseno(g);
                b = operarCoseno(b);

                filter.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }
        return filter;
    }
    
    @Override
    public BufferedImage filtroExponencial(BufferedImage image, double alfa) {
        BufferedImage filter = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        double A = L / (Math.exp(alfa) - 1);
        for (int i = 0; i < filter.getWidth(); i++) {
            for (int j = 0; j < filter.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                r = operarExponencial(A, alfa, r);
                g = operarExponencial(A, alfa, g);
                b = operarExponencial(A, alfa, b);

                filter.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }
        return filter;
    }
    
    @Override
    public BufferedImage filtroSigmoide(BufferedImage image, double landa) {
        BufferedImage filter = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < filter.getWidth(); i++) {
            for (int j = 0; j < filter.getHeight(); j++) {
                Color color = new Color(image.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                r = operarSigmoide(landa, r);
                g = operarSigmoide(landa, g);
                b = operarSigmoide(landa, b);

                filter.setRGB(i, j, new Color(r, g, b).getRGB());
            }
        }
        return filter;
    }

    private int operarLogaritmo(double A, double alfa, int z) {
        return (int) (A * Math.log(alfa * z + 1));
    }
    
    private int operarSeno(int z){
        return (int)(L*Math.sin((Math.PI*z)/(2*L)));
    }
    
    private int operarCoseno(int z){
        return (int)(L*(1-Math.cos((Math.PI*z)/(2*L))));
    }
    
    private int operarExponencial(double A, double alfa, int z) {
        return (int) (A * (Math.exp(alfa*z/L) - 1));
    }
    
    private int operarSigmoide(double landa, int z){
        return (int)(z-(landa*Math.sin((2*Math.PI*z)/L)));
    }

}
