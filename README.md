# Nullbyte Notepad

**Nullbyte Notepad** is an offline-first, Markdown-based note-taking application built with Flask and SQLite, with optional Android support via Chaquopy. It is lightweight, extensible, and ideal for capturing personal notes, recipes, research, and more — all with optional manual sync across devices.

---

## Features

- Live Markdown editor with preview  
- Tagging and filtering system  
- Full-text client-side search  
- Offline-first with local SQLite storage  
- Manual device-to-device sync (via REST)  
- Android APK support using embedded WebView and Flask backend

---

## Getting Started

### Backend (Flask)

```bash
cd flask_app
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
pip install -r requirements.txt
python run.py
# Open http://127.0.0.1:5000 in browser
```

### Android

```bash
cd android
# Open project in Android Studio
# Run on emulator or device
```

---

## Tech Stack

| Layer        | Technology                          |
|--------------|-------------------------------------|
| Frontend     | Bootstrap 5, Vanilla JS, Showdown.js |
| Markdown     | SimpleMDE                           |
| Backend      | Flask, SQLite, SQLAlchemy           |
| Android      | Android Studio + Chaquopy (Python)  |
| Sync Method  | REST API endpoints                  |

---

## Data Model

### Notes

| Field         | Type      | Description                       |
|---------------|-----------|-----------------------------------|
| uuid          | UUID      | Unique global note ID             |
| title         | String    | Note title                        |
| markdown      | Text      | Raw markdown content              |
| last_modified | Timestamp | For sync conflict resolution      |
| deleted       | Boolean   | Marks soft-deleted notes          |

### Tags

| Field | Type   | Description     |
|-------|--------|-----------------|
| name  | String | Tag name        |

---

## Sync API

### POST /sync/push

Push locally modified notes to another device.

### GET /sync/pull

Pull updated notes from another device.

> Syncing is based on `last_modified` timestamps. Soft-deleted notes are honored and propagated.

---

## Roadmap (MVP)

1. Markdown notes with tagging and local storage  
2. Flask REST API for sync  
3. Android APK with embedded Flask server  
4. Markdown export/import with frontmatter support

---

## License

Licensed under the [MIT License](LICENSE).
