# Nullbyte Notepad

**Nullbyte Notepad** is an offline-first, Markdown-based note-taking application built with Flask and SQLite. It supports optional manual sync across devices, including Android. Designed to be lightweight, portable, and extensible, it is ideal for storing personal notes, recipes, workout logs, and research content.

---

# Getting Started

### Backend (Flask)
cd backend
python -m venv venv
pip install -r requirements.txt
python run.py
visit http://localhost:5000

### Android
cd android
open in Android Studio
Run app in emulator/device

---

## Features

- Markdown note editor with live preview
- Tagging system for organizing and filtering notes
- Full-text client-side search
- Local SQLite storage for offline access
- Manual sync across devices using a REST API or optional `.md` file export
- Android APK support via embedded WebView and local Flask server

---

## Tech Stack

| Layer         | Technology                       |
|---------------|----------------------------------|
| Frontend      | Bootstrap 5, Vanilla JS, Showdown.js |
| Markdown Editor | SimpleMDE                     |
| Backend       | Flask, SQLite, SQLAlchemy        |
| Android       | Android Studio + Chaquopy (Python) |
| Sync Method   | Manual REST API endpoints        |

---

## Data Model

### Notes Table

| Field         | Type       | Description                     |
|---------------|------------|---------------------------------|
| uuid          | UUID       | Unique global note ID           |
| title         | String     | Note title                      |
| markdown      | Text       | Raw Markdown content            |
| last_modified | Timestamp  | Used for sync conflict resolution |
| deleted       | Boolean    | Marks soft-deleted notes        |

### Tags Table

| Field | Type   | Description     |
|-------|--------|-----------------|
| name  | String | Tag name        |

---

## Sync API

### POST /sync/push

Pushes all locally modified notes (since last sync) to a remote Flask endpoint.

### GET /sync/pull

Pulls updated notes from a remote source into the local device.

Notes are merged based on `last_modified` timestamps. Soft deletions are honored during sync.

---

## Roadmap (MVP)

1. Local Flask app with markdown notes and tagging support
2. Android APK with embedded WebView and Flask server
3. Manual REST sync between devices
4. Markdown export/import with frontmatter for versioned backups

---

## Repository Structure

nullbyte-notepad/
├── app/
│ ├── models.py
│ ├── routes.py
│ ├── templates/
│ ├── static/
│ └── init.py
├── android_app/
│ └── main_webview_wrapper/
├── sync/
│ ├── sync_push.py
│ └── sync_pull.py
├── export/
│ └── md_exporter.py
├── README.md
├── requirements.txt
└── run.py