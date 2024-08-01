class FrontEnd {
    checkBoxNavResponsive;
    divOcultar;
    divHeaderContactInfo;
    divFooterDerechos;

    constructor() {
        this.checkBoxNavResponsive = null;
        this.divOcultar = null;
        this.divHeaderContactInfo = null;
        this.divFooterDerechos = null;
    }

    getCheckBoxNavResponsive() {
        return this.checkBoxNavResponsive;
    }

    setCheckBoxNavResponsive(htmlCheckId) {
        this.checkBoxNavResponsive = htmlCheckId;
    }

    getDivOcultar() {
        return this.divOcultar;
    }

    setDivOcultar(htmlDivOcultar) {
        this.divOcultar = htmlDivOcultar;
    }

    getDivHeaderContactIfo(){
        return this.divHeaderContactInfo;
    }

    setDivHeaderContactIfo(htmlDivContactInfo){
        this.divHeaderContactInfo = htmlDivContactInfo;
    }

    getDivFooterDerechos(){
        return this.divFooterDerechos;
    }

    setDivFooterDerechos(htmlDivFooterDerechos){
        this.divFooterDerechos = htmlDivFooterDerechos;
    }

    ajuntarHeader(){
        var divAdjuntar = this.getDivHeaderContactIfo();
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET", "/headerContact", true);
        xmlhttp.send();

        xmlhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                divAdjuntar.innerHTML = this.responseText;
            }
        };
    }

    adjuntarFooter(){
        var divAdjuntar = this.getDivFooterDerechos();
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET", "/footerDerechos", true);
        xmlhttp.send();

        xmlhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                divAdjuntar.innerHTML = this.responseText;
            }
        };
    }
}

function inicializar() {
    const frontend = new FrontEnd();

    frontend.setDivHeaderContactIfo(document.getElementById("header-contact-info-container"));
    frontend.ajuntarHeader();
    frontend.setDivFooterDerechos(document.getElementById("footer-derechos"));
    frontend.adjuntarFooter();
}
