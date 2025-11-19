import httpx
from typing import Optional

INVENTORY_SERVICE_URL = "http://localhost:8080/api/"

async def get_supplier_info(supplier_id: int) -> Optional[dict]:
    async with httpx.AsyncClient() as client:
        try:
            res = await client.get(f"{INVENTORY_SERVICE_URL}owners/{supplier_id}")
            res.raise_for_status()
            return res.json()
        except httpx.HTTPError:
            return None

async def get_product_info(product_id: int) -> Optional[dict]:
    async with httpx.AsyncClient() as client:
        try:
            res = await client.get(f"{INVENTORY_SERVICE_URL}products/{product_id}")
            res.raise_for_status()
            return res.json()
        except httpx.HTTPError:
            return None
