/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itgarden.repository.follow_up_report;

import itgarden.model.follow_up_report.MotherCrisisMeetUp;
import itgarden.model.homevisit.MotherMasterData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface MotherCrisisMeetUpRepository extends JpaRepository<MotherCrisisMeetUp, Long> {
    
    
    List<MotherCrisisMeetUp> findBymotherMasterCode(MotherMasterData motherMasterData);
    
    
}
