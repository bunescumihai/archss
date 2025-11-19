from fastapi import FastAPI
from src.app.routers import offers, supplier_profiles, offer_items

app = FastAPI(title="Offers API")

app.include_router(offers.router)
app.include_router(supplier_profiles.router)
app.include_router(offer_items.router)

@app.get("/")
def root():
    return {"message": "FastAPI Offers API running"}
