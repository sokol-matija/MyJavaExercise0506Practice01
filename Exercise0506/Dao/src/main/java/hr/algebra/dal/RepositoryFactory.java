/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.dal;

import hr.algebra.dal.file.FileRepository;
import java.io.IOException;

/**
 *
 * @author lecturerf6
 */
public class RepositoryFactory {

    // 1.
    private RepositoryFactory() {
    }
    // 2. 
    private static Repository INSTANCE;
    
    public static Repository getRepository() throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new FileRepository();
        }
        return INSTANCE;
    }
    
}
