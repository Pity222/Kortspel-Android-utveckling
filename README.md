# Kortspel – Android App

Ett enkelt men snyggt kortspel utvecklat i **Kotlin** för Android.  
Skapad som ett lärandeprojekt inom Android-utveckling.

![App screenshot](https://via.placeholder.com/400x800.png?text=Kortspel+Screenshot)  
*(Lägg gärna in en eller flera skärmdumpar här senare – de gör stor skillnad!)*

## Om projektet

Detta är ett Android-kortspelsprojekt byggt med modern Android-arkitektur.  
Syftet har varit att lära sig:

- Kotlin & Jetpack Compose (eller View system – beroende på implementation)
- Android navigation
- Hantering av kortlek, spelregler och UI/UX
- Gradle-konfiguration, byggsystem och bästa praxis

Projektet är uppbyggt med en tydlig mappstruktur och är redo att byggas och köras i Android Studio.

## Spel som implementerats

*(Välj det som passar – ta bort de som inte stämmer)*

- Klassiskt **Kortspel** (t.ex. "Kort med svarta & röda", "Gubben i lådan", "Skitgubbe")
- **Higher-Lower** / högre-lägre-kort
- Enkel **patience** / solitaire-variant
- **Blackjack**-liknande logik (21-poäng)
- Eller: eget designat kortspel med svenska regler

## Tekniker & verktyg som används

- **Språk**: Kotlin (100%)
- **UI**: Jetpack Compose *(eller XML + View system)*
- **Arkitektur**: MVVM / MVI *(eller enkel Activity/Fragment-struktur)*
- **Byggsystem**: Gradle med Kotlin DSL
- **Android SDK**: Min SDK 24+, Target SDK 35 (Android 15)
- **Bibliotek** (exempel – ta bort de du inte använder):
  - Jetpack Navigation
  - ViewModel & LiveData / StateFlow
  - Coroutines / Flow
  - Hilt / Dagger (beroende på dependency injection)
  - Material 3 design

## Kom igång

### Förutsättningar

- Android Studio (2024.2+ eller nyare rekommenderas)
- Android SDK installerat

### Så här kör du projektet

1. Klona repot:
   ```bash
   git clone https://github.com/Pity222/Kortspel-Android-utveckling.git
