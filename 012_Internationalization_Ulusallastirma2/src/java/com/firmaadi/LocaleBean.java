/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firmaadi;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author husey
 */
@ManagedBean(name = "dil")
@RequestScoped
public class LocaleBean {

    /**
     * Creates a new instance of LocaleBean
     */
    private String yerelDurum;
    private Map<String,Object> ulkelerHaritasi;
    public LocaleBean() {
        ulkelerHaritasi = new LinkedHashMap<String, Object>();
        ulkelerHaritasi.put("Türkçe", new Locale("tr", "TR"));
        ulkelerHaritasi.put("English", new Locale("en", "EN"));
        ulkelerHaritasi.put("Pусский", new Locale("ru", "RU"));
        ulkelerHaritasi.put("العربية", new Locale("ar", "AR"));
    }

    public String getYerelDurum() {
        return yerelDurum;
    }

    public void setYerelDurum(String yerelDurum) {
        this.yerelDurum = yerelDurum;
    }

    public Map<String, Object> getUlkelerHaritasi() {
        return ulkelerHaritasi;
    }

    public void setUlkelerHaritasi(Map<String, Object> ulkelerHaritasi) {
        this.ulkelerHaritasi = ulkelerHaritasi;
    }
    
    //değer değişimi olay dinleyicisi
    public void ulkeninYerelKoduDegisti(ValueChangeEvent changeEvent){
        String yeniYerelKodDegeri = changeEvent.getNewValue().toString();
        for(Map.Entry<String,Object> entry : ulkelerHaritasi.entrySet()){
            if(entry.getValue().toString().equals(yeniYerelKodDegeri)){
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
            }
        }
    }
    
}
