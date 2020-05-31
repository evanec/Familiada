import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
import '@vaadin/vaadin-button/vaadin-button.js';
class AdminView extends PolymerElement {
  static get template() {
    return html`
<link rel="stylesheet" href="frontend/style.css">
    <div class="logo">FANTASTYCZNA FAMILIADA</div>
<div class="window">
    <div>
        <div class="question" id="question">Ile waży koń trojański?</div>
                <div class="textTooltip">
        <vaadin-text-field id="addAnswerField" class="textInput" theme="medium" placeholder="Wprowadź tutaj odpowiedź do pytania">
        </vaadin-text-field>
        <div class="bubble">Zostań jednym z naszych Ankietowanych dodając odpowiedzi na pytania z zakresu szerokopojętej fantastyki, Sciece fiction, filmów, książek, gier, papierowych rpg i tym podobnych.</div>
         </div>
        <div class="buttons">
            <vaadin-button theme="" id="saveAnswer" class="button">
              <iron-icon icon="lumo:plus" slot="prefix"></iron-icon>
                Dodaj odpowiedź
            </vaadin-button>
            <vaadin-button theme="" id="ignore" class="button middleButton">
                <iron-icon icon="lumo:angle-right" slot="prefix"></iron-icon>
                Pomiń
            </vaadin-button>
            <vaadin-button theme="error" id="report" class="button">
                <iron-icon icon="lumo:cross" slot="prefix"></iron-icon>
                Zgłoś pytanie
            </vaadin-button>
        </div>
    </div>

     <hr>

    <div>
                    <div class="textTooltip">
         <vaadin-text-field class="textInput" placeholder="Dodaj pytanie"></vaadin-text-field>
                 <div class="bubbleLeft">Możesz też dodać własną propozycję pytania.</div>
                  </div>
        <div class="buttons">
            <vaadin-button theme="size-l" id="saveQuestion" class="button">
            <iron-icon icon="lumo:plus" slot="prefix"></iron-icon>
                Dodaj pytanie
            </vaadin-button>
        </div>
    </div>
</div>
    `;
  }

  static get is() {
    return 'admin-view';
  }
}

customElements.define(AdminView.is, AdminView);