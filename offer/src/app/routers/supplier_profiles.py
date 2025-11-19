from fastapi import APIRouter, Depends
from sqlalchemy.ext.asyncio import AsyncSession
from ..database import get_db
from .. import schemas, crud

router = APIRouter(prefix="/api/supplier-profiles", tags=["supplier_profiles"])

@router.post("/", response_model=schemas.SupplierProfileRead)
async def create_supplier(supplier: schemas.SupplierProfileCreate, db: AsyncSession = Depends(get_db)):
    return await crud.create_supplier(db, supplier)

@router.get("/", response_model=list[schemas.SupplierProfileRead])
async def list_suppliers(db: AsyncSession = Depends(get_db)):
    return await crud.get_suppliers(db)
