import sys
import os

# Navigate up to root where flask_app/ is
repo_root = os.path.abspath(os.path.join(os.path.dirname(__file__), "../../../.."))
sys.path.insert(0, repo_root)

from flask_app import create_app

def run_server(host="0.0.0.0", port=5000):
    app = create_app()
    app.run(host=host, port=port, debug=False)
