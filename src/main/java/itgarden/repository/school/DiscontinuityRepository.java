/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository.school;

import itgarden.model.school.Discontinuity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Md Belayet Hossin
 */
public interface DiscontinuityRepository extends JpaRepository<Discontinuity, Long> {
    
}