package com.convergence.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class AtomDTO implements Serializable {
	@Id
    private Integer atomId;

    private String citizenId;

    private String realName;

    private String coptLevel;

    private String coptAddress;

    private String coptContactInfo;

    private String coptZip;

    private String coptName;

    private String sex;

    private String birthDay;

    private String birthMonth;

    private String birthYear;

    private Date birth;

    private String education;

    private Date workdate;

    private String address;

    private String zip;

    private String tel;

    private String fax;

    private String ecotype;

    private String tradeProperty;

    private String tradeCode;

    private String qq;

    private String sh;

    private String hip;

    private String age;

    private String bust;

    private String weibo;

    private String hobby;

    private String email;

    private String astro;

    private String weight;

    private String height;

    private String weixin;

    private String school;

    private String nation;

    private Integer tptotal;

    private String userName;

    private String password;

    private String waistline;

    private String specialty;

    private String birthplace;

    private String question;

    private String answer;

    private String status;

    private String contactInfo;

    private String ip;

    private String msn;

    private String payPassword;

    private String homePhone;

    private String depart;

    private String aliww;

    private String icq;

    private String yahoo;

    private String site;

    private String lastip;

    private String remark;

    private String dataFrom;

    private String province;

    private static final long serialVersionUID = 1L;

    public Integer getAtomId() {
        return atomId;
    }

    public void setAtomId(Integer atomId) {
        this.atomId = atomId;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId == null ? null : citizenId.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getCoptLevel() {
        return coptLevel;
    }

    public void setCoptLevel(String coptLevel) {
        this.coptLevel = coptLevel == null ? null : coptLevel.trim();
    }

    public String getCoptAddress() {
        return coptAddress;
    }

    public void setCoptAddress(String coptAddress) {
        this.coptAddress = coptAddress == null ? null : coptAddress.trim();
    }

    public String getCoptContactInfo() {
        return coptContactInfo;
    }

    public void setCoptContactInfo(String coptContactInfo) {
        this.coptContactInfo = coptContactInfo == null ? null : coptContactInfo.trim();
    }

    public String getCoptZip() {
        return coptZip;
    }

    public void setCoptZip(String coptZip) {
        this.coptZip = coptZip == null ? null : coptZip.trim();
    }

    public String getCoptName() {
        return coptName;
    }

    public void setCoptName(String coptName) {
        this.coptName = coptName == null ? null : coptName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay == null ? null : birthDay.trim();
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth == null ? null : birthMonth.trim();
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear == null ? null : birthYear.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Date getWorkdate() {
        return workdate;
    }

    public void setWorkdate(Date workdate) {
        this.workdate = workdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEcotype() {
        return ecotype;
    }

    public void setEcotype(String ecotype) {
        this.ecotype = ecotype == null ? null : ecotype.trim();
    }

    public String getTradeProperty() {
        return tradeProperty;
    }

    public void setTradeProperty(String tradeProperty) {
        this.tradeProperty = tradeProperty == null ? null : tradeProperty.trim();
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode == null ? null : tradeCode.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getSh() {
        return sh;
    }

    public void setSh(String sh) {
        this.sh = sh == null ? null : sh.trim();
    }

    public String getHip() {
        return hip;
    }

    public void setHip(String hip) {
        this.hip = hip == null ? null : hip.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust == null ? null : bust.trim();
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo == null ? null : weibo.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAstro() {
        return astro;
    }

    public void setAstro(String astro) {
        this.astro = astro == null ? null : astro.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public Integer getTptotal() {
        return tptotal;
    }

    public void setTptotal(Integer tptotal) {
        this.tptotal = tptotal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline == null ? null : waistline.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace == null ? null : birthplace.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo == null ? null : contactInfo.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone == null ? null : homePhone.trim();
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    public String getAliww() {
        return aliww;
    }

    public void setAliww(String aliww) {
        this.aliww = aliww == null ? null : aliww.trim();
    }

    public String getIcq() {
        return icq;
    }

    public void setIcq(String icq) {
        this.icq = icq == null ? null : icq.trim();
    }

    public String getYahoo() {
        return yahoo;
    }

    public void setYahoo(String yahoo) {
        this.yahoo = yahoo == null ? null : yahoo.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip == null ? null : lastip.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(String dataFrom) {
        this.dataFrom = dataFrom == null ? null : dataFrom.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AtomDTO other = (AtomDTO) that;
        return (this.getAtomId() == null ? other.getAtomId() == null : this.getAtomId().equals(other.getAtomId()))
            && (this.getCitizenId() == null ? other.getCitizenId() == null : this.getCitizenId().equals(other.getCitizenId()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getCoptLevel() == null ? other.getCoptLevel() == null : this.getCoptLevel().equals(other.getCoptLevel()))
            && (this.getCoptAddress() == null ? other.getCoptAddress() == null : this.getCoptAddress().equals(other.getCoptAddress()))
            && (this.getCoptContactInfo() == null ? other.getCoptContactInfo() == null : this.getCoptContactInfo().equals(other.getCoptContactInfo()))
            && (this.getCoptZip() == null ? other.getCoptZip() == null : this.getCoptZip().equals(other.getCoptZip()))
            && (this.getCoptName() == null ? other.getCoptName() == null : this.getCoptName().equals(other.getCoptName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthDay() == null ? other.getBirthDay() == null : this.getBirthDay().equals(other.getBirthDay()))
            && (this.getBirthMonth() == null ? other.getBirthMonth() == null : this.getBirthMonth().equals(other.getBirthMonth()))
            && (this.getBirthYear() == null ? other.getBirthYear() == null : this.getBirthYear().equals(other.getBirthYear()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getWorkdate() == null ? other.getWorkdate() == null : this.getWorkdate().equals(other.getWorkdate()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getZip() == null ? other.getZip() == null : this.getZip().equals(other.getZip()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getEcotype() == null ? other.getEcotype() == null : this.getEcotype().equals(other.getEcotype()))
            && (this.getTradeProperty() == null ? other.getTradeProperty() == null : this.getTradeProperty().equals(other.getTradeProperty()))
            && (this.getTradeCode() == null ? other.getTradeCode() == null : this.getTradeCode().equals(other.getTradeCode()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getSh() == null ? other.getSh() == null : this.getSh().equals(other.getSh()))
            && (this.getHip() == null ? other.getHip() == null : this.getHip().equals(other.getHip()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getBust() == null ? other.getBust() == null : this.getBust().equals(other.getBust()))
            && (this.getWeibo() == null ? other.getWeibo() == null : this.getWeibo().equals(other.getWeibo()))
            && (this.getHobby() == null ? other.getHobby() == null : this.getHobby().equals(other.getHobby()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAstro() == null ? other.getAstro() == null : this.getAstro().equals(other.getAstro()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getWeixin() == null ? other.getWeixin() == null : this.getWeixin().equals(other.getWeixin()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getTptotal() == null ? other.getTptotal() == null : this.getTptotal().equals(other.getTptotal()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getWaistline() == null ? other.getWaistline() == null : this.getWaistline().equals(other.getWaistline()))
            && (this.getSpecialty() == null ? other.getSpecialty() == null : this.getSpecialty().equals(other.getSpecialty()))
            && (this.getBirthplace() == null ? other.getBirthplace() == null : this.getBirthplace().equals(other.getBirthplace()))
            && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getContactInfo() == null ? other.getContactInfo() == null : this.getContactInfo().equals(other.getContactInfo()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getMsn() == null ? other.getMsn() == null : this.getMsn().equals(other.getMsn()))
            && (this.getPayPassword() == null ? other.getPayPassword() == null : this.getPayPassword().equals(other.getPayPassword()))
            && (this.getHomePhone() == null ? other.getHomePhone() == null : this.getHomePhone().equals(other.getHomePhone()))
            && (this.getDepart() == null ? other.getDepart() == null : this.getDepart().equals(other.getDepart()))
            && (this.getAliww() == null ? other.getAliww() == null : this.getAliww().equals(other.getAliww()))
            && (this.getIcq() == null ? other.getIcq() == null : this.getIcq().equals(other.getIcq()))
            && (this.getYahoo() == null ? other.getYahoo() == null : this.getYahoo().equals(other.getYahoo()))
            && (this.getSite() == null ? other.getSite() == null : this.getSite().equals(other.getSite()))
            && (this.getLastip() == null ? other.getLastip() == null : this.getLastip().equals(other.getLastip()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getDataFrom() == null ? other.getDataFrom() == null : this.getDataFrom().equals(other.getDataFrom()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAtomId() == null) ? 0 : getAtomId().hashCode());
        result = prime * result + ((getCitizenId() == null) ? 0 : getCitizenId().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getCoptLevel() == null) ? 0 : getCoptLevel().hashCode());
        result = prime * result + ((getCoptAddress() == null) ? 0 : getCoptAddress().hashCode());
        result = prime * result + ((getCoptContactInfo() == null) ? 0 : getCoptContactInfo().hashCode());
        result = prime * result + ((getCoptZip() == null) ? 0 : getCoptZip().hashCode());
        result = prime * result + ((getCoptName() == null) ? 0 : getCoptName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthDay() == null) ? 0 : getBirthDay().hashCode());
        result = prime * result + ((getBirthMonth() == null) ? 0 : getBirthMonth().hashCode());
        result = prime * result + ((getBirthYear() == null) ? 0 : getBirthYear().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getWorkdate() == null) ? 0 : getWorkdate().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getZip() == null) ? 0 : getZip().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getEcotype() == null) ? 0 : getEcotype().hashCode());
        result = prime * result + ((getTradeProperty() == null) ? 0 : getTradeProperty().hashCode());
        result = prime * result + ((getTradeCode() == null) ? 0 : getTradeCode().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getSh() == null) ? 0 : getSh().hashCode());
        result = prime * result + ((getHip() == null) ? 0 : getHip().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getBust() == null) ? 0 : getBust().hashCode());
        result = prime * result + ((getWeibo() == null) ? 0 : getWeibo().hashCode());
        result = prime * result + ((getHobby() == null) ? 0 : getHobby().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAstro() == null) ? 0 : getAstro().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getWeixin() == null) ? 0 : getWeixin().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getTptotal() == null) ? 0 : getTptotal().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getWaistline() == null) ? 0 : getWaistline().hashCode());
        result = prime * result + ((getSpecialty() == null) ? 0 : getSpecialty().hashCode());
        result = prime * result + ((getBirthplace() == null) ? 0 : getBirthplace().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getContactInfo() == null) ? 0 : getContactInfo().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getMsn() == null) ? 0 : getMsn().hashCode());
        result = prime * result + ((getPayPassword() == null) ? 0 : getPayPassword().hashCode());
        result = prime * result + ((getHomePhone() == null) ? 0 : getHomePhone().hashCode());
        result = prime * result + ((getDepart() == null) ? 0 : getDepart().hashCode());
        result = prime * result + ((getAliww() == null) ? 0 : getAliww().hashCode());
        result = prime * result + ((getIcq() == null) ? 0 : getIcq().hashCode());
        result = prime * result + ((getYahoo() == null) ? 0 : getYahoo().hashCode());
        result = prime * result + ((getSite() == null) ? 0 : getSite().hashCode());
        result = prime * result + ((getLastip() == null) ? 0 : getLastip().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDataFrom() == null) ? 0 : getDataFrom().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", atomId=").append(atomId);
        sb.append(", citizenId=").append(citizenId);
        sb.append(", realName=").append(realName);
        sb.append(", coptLevel=").append(coptLevel);
        sb.append(", coptAddress=").append(coptAddress);
        sb.append(", coptContactInfo=").append(coptContactInfo);
        sb.append(", coptZip=").append(coptZip);
        sb.append(", coptName=").append(coptName);
        sb.append(", sex=").append(sex);
        sb.append(", birthDay=").append(birthDay);
        sb.append(", birthMonth=").append(birthMonth);
        sb.append(", birthYear=").append(birthYear);
        sb.append(", birth=").append(birth);
        sb.append(", education=").append(education);
        sb.append(", workdate=").append(workdate);
        sb.append(", address=").append(address);
        sb.append(", zip=").append(zip);
        sb.append(", tel=").append(tel);
        sb.append(", fax=").append(fax);
        sb.append(", ecotype=").append(ecotype);
        sb.append(", tradeProperty=").append(tradeProperty);
        sb.append(", tradeCode=").append(tradeCode);
        sb.append(", qq=").append(qq);
        sb.append(", sh=").append(sh);
        sb.append(", hip=").append(hip);
        sb.append(", age=").append(age);
        sb.append(", bust=").append(bust);
        sb.append(", weibo=").append(weibo);
        sb.append(", hobby=").append(hobby);
        sb.append(", email=").append(email);
        sb.append(", astro=").append(astro);
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", weixin=").append(weixin);
        sb.append(", school=").append(school);
        sb.append(", nation=").append(nation);
        sb.append(", tptotal=").append(tptotal);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", waistline=").append(waistline);
        sb.append(", specialty=").append(specialty);
        sb.append(", birthplace=").append(birthplace);
        sb.append(", question=").append(question);
        sb.append(", answer=").append(answer);
        sb.append(", status=").append(status);
        sb.append(", contactInfo=").append(contactInfo);
        sb.append(", ip=").append(ip);
        sb.append(", msn=").append(msn);
        sb.append(", payPassword=").append(payPassword);
        sb.append(", homePhone=").append(homePhone);
        sb.append(", depart=").append(depart);
        sb.append(", aliww=").append(aliww);
        sb.append(", icq=").append(icq);
        sb.append(", yahoo=").append(yahoo);
        sb.append(", site=").append(site);
        sb.append(", lastip=").append(lastip);
        sb.append(", remark=").append(remark);
        sb.append(", dataFrom=").append(dataFrom);
        sb.append(", province=").append(province);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}