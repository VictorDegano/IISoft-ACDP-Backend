package iisoft.acdp.backend

import iisoft.acdp.backend.authentication.NormalUser
import iisoft.acdp.backend.UserProfile

class UserRegisterForm {

    String name
    String password
    String userName
    String surname
    String mail
    Date   birthDate

    static constraints = {

    }

    UserRegisterForm(){}

    UserRegisterForm(NormalUser normalUser, UserProfile userProfile){
        name     = userProfile.name
        password = normalUser.password
        userName = normalUser.username
        surname  = userProfile.surname
        mail     = userProfile.mail
        birthDate= userProfile.birthDate
    }

    NormalUser hidrateUser() {
        NormalUser usuario = new NormalUser(password: this.password,username: this.userName)
        return usuario
    }

    UserProfile hidrateprofile(long userID) {
        UserProfile userProfile = new UserProfile(name: name, surname:surname, mail:mail , birthDate: birthDate, userID: userID,userName: this.userName, work: "dev", git:"git", linkedin: "linkedin",career: "Tpi", approvedSubjects:["Intro"] )
        return userProfile
    }
}
