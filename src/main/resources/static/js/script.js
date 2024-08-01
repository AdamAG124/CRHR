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

    ocultarDiv() {
        if (this.checkBoxNavResponsive.checked) {
            // Ocultar el div si el checkbox está marcado
            setTimeout(() => {
                this.getDivOcultar().style.display = "none";
            }, 50); // Ejemplo: 300 milisegundos
        } else {
            // Mostrar el div si el checkbox no está marcado
            setTimeout(() => {
                this.getDivOcultar().style.display = "flex";
            }, 300);
        }
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

    frontend.setCheckBoxNavResponsive(document.getElementById("check"));
    frontend.setDivOcultar(document.getElementById("front-page-text"));
    frontend.setDivHeaderContactIfo(document.getElementById("header-contact-info-container"));
    frontend.ajuntarHeader();
    frontend.setDivFooterDerechos(document.getElementById("footer-derechos"));
    frontend.adjuntarFooter();
    frontend.getCheckBoxNavResponsive().addEventListener('change', () => {
        frontend.ocultarDiv();
    });
}
