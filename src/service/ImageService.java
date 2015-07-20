/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.image.BufferedImage;

/**
 *
 * @author Hugo
 */
public interface ImageService {
    
    public static final int L = 255;
    
    public BufferedImage filtroNegativo(BufferedImage image);
    
    public BufferedImage filtroLogaritmico(BufferedImage image, double alfa);
    
    public BufferedImage filtroSeno(BufferedImage image);
    
    public BufferedImage filtroCoseno(BufferedImage image);
    
    public BufferedImage filtroExponencial(BufferedImage image, double alfa);
    
    public BufferedImage filtroSigmoide(BufferedImage image, double landa);
    
}
