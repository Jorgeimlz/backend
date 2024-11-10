"""
WSGI config for NutriSync project.

It exposes the WSGI callable as a module-level variable named ``application``.

For more information on this file, see
https://docs.djangoproject.com/en/5.1/howto/deployment/wsgi/
"""

# NutriSync/wsgi.py
import os
from django.core.wsgi import get_wsgi_application

# Asegúrate de que esta línea apunte a tus configuraciones de Django correctamente
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'NutriSync.settings')

application = get_wsgi_application()
