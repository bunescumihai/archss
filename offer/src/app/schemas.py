from datetime import datetime
from pydantic import BaseModel

# SupplierProfile
class SupplierProfileCreate(BaseModel):
    supplier_id: int
    company_name: str | None = None
    region: str | None = None
    contact_info: str | None = None

class SupplierProfileRead(BaseModel):
    id: int
    supplier_id: int
    company_name: str | None
    region: str | None
    contact_info: str | None

    class Config:
        orm_mode = True

# Offer
class OfferCreate(BaseModel):
    supplier_profile_id: int
    title: str
    description: str | None = None
    status: str | None = None
    valid_until: datetime | None = None

class OfferRead(OfferCreate):
    id: int
    created_at: datetime

    class Config:
        orm_mode = True

# OfferItem
class OfferItemCreate(BaseModel):
    offer_id: int
    product_id: int | None
    product_name: str | None
    available_quantity: float | None
    unit_price: float | None
    unit: str | None

class OfferItemRead(OfferItemCreate):
    id: int
    total_value: float | None

    class Config:
        orm_mode = True
